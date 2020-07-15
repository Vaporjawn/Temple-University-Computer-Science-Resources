/* jshint esversion: 8 */

const functions = require('firebase-functions');

const admin = require('firebase-admin');
admin.initializeApp();

const request = require('request-promise');
const _ = require('lodash');
const GLOBAL_KEY = 'AIzaSyBw8ZuhQdGloFKMVWiFljNXACN1QUXsKPc';

// This event handler will run whenever a new account is created
// through the Firebase authentication mechanisms
exports.createUser = functions.auth.user().onCreate((event) => {
  const user = event.data || null;
  const id = user.uid || '';
  const displayName = user.displayName || null;
  const photoURL = user.photoURL || null;

  if (user === null ||
      id === null ||
      displayName === null||
      photoURL === null) {
    return false;
  }

  try {
    admin.database().ref(`/users/${id}/name`).set(`${displayName}`);
    admin.database().ref(`/users/${id}/chatIds`).set('');
    admin.database().ref(`/users/${id}/friends`).set('');
  } catch (error) {
    console.log('Error during createUser(): ' + error);
    return false;
  }

  return true;
});

// This HTTPS request must include a parameter labelled 'userId'
exports.deleteUser = functions.https.onRequest((request, response) => {
  const userIdentifier = request.body.userId || null;
  const FieldValue = admin.firestore.FieldValue || null;
  const usersReference = db.collection('users').doc(`${userIdentifier}`) ||
        null;

  if (userIdentifier === null ||
      FieldValue === null ||
      usersReference === null) {
    response.send(false);
  }

  try {
    usersReference.update({
      userIdentifier: FieldValue.delete(),
    });
  } catch (error) {
    console.log('Error during deleteUser(): ' + error);
    response.send(false);
  }

  response.send(true);
});

// Promise-based check to find if a user does exist in the database system
exports.doesUserExist = functions.https.onRequest((request, response) => {
  const userIdentifier = request.body.userId || null;

  if (userIdentifier === null) {
    response.send(false);
  }

  const userReference = db.collection('users').doc(`${userIdentifier}`);
  docRef.get().then((doc) => {
    if (doc.exists) {
      response.send(true);
      return true;
    } else {
      response.send(false);
      return true;
    }
  }).catch((error) => {
    console.log('Error during doesUserExist(): ' + error);
    response.send(null);
    return false;
  });
});

// Get each new message creation event and translate it, then add back to Firestore
exports.translateInitialMessage = functions.firestore.document(`messages/{id}`).onCreate(async (snapshot, context) => {
  // Check that message and language exist
  if (snapshot.data().isTextBased === null) {
    console.log('Error: isTextBased field is invalid');
    return null;
  }

  if (snapshot.data().isTextBased) {
    // Text-based
    if (snapshot.data().originalLanguage === null ||
        snapshot.data().oldMessage === null) {
      console.log('Error: originalLanguage or originalMessage field is invalid');
      return null;
    }

    const getTranslatedMessage = (_sourceLang, _targetLang, _text) => {
      const createTranslateUrl = (source, target, text) => {
        const message = encodeURIComponent(text);
        return `https://www.googleapis.com/language/translate/v2?key=${GLOBAL_KEY}&source=${source}&target=${target}&q=${message}`;
      };

      const t = {};
      t[_sourceLang] = _text;
      if (_sourceLang === _targetLang) {
        return admin.firestore().doc(`messages/${context.params.id}`).set({
          translations: t,
        }, {merge: true});
      }

      const translation = {};
      return request(createTranslateUrl(_sourceLang, _targetLang, _text), {resolveWithFullResponse: true}).then((response) => {
        if (response.statusCode === 200) {
          const resData = JSON.parse(response.body).data;

          translation[_targetLang] = resData.translations[0].translatedText;

          return admin.firestore().doc(`messages/${context.params.id}`).set({
            translations: translation,
          }, {merge: true});
        } else {
          throw response.body;
        }
      });
    };

    const promises = [];

    // Allowed languages
    const allowedLanguages = [
      'en',
      'es',
      'ko',
      'it',
      'ru',
      'fr',
      'ur',
    ];

    // All Translations to update into document
    const allTranslations = {};
    const oldLanguage = snapshot.data().originalLanguage;
    const oldMessage = snapshot.data().originalMessage;

    _.each(allowedLanguages, (lang) => {
      promises.push(getTranslatedMessage(oldLanguage, lang, oldMessage));
    });

    return Promise.all(promises);
  } else {
    // Chat-based
    if (snapshot.data().originalVoice === null) {
      console.log('Error: originalVoice field is invalid');
      return null;
    }

    // Translate here and add to firebase in a promise

    return null;
  }
});
