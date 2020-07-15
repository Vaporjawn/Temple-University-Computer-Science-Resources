import {Injectable} from '@angular/core';
import {auth} from 'firebase/app';
import {AngularFireAuth} from '@angular/fire/auth';
import {AngularFirestore} from '@angular/fire/firestore';
import {UserService} from './user.service';

@Injectable({
  providedIn: 'root',
})

export class AuthService {
  constructor(public Auth: AngularFireAuth, private db: AngularFirestore) { }

  // Sign in with Google
  GoogleAuth() {
    return this.AuthLogin(new auth.GoogleAuthProvider());
  }

  // Auth logic to run auth providers
  AuthLogin(provider) {
    return this.Auth.auth.signInWithPopup(provider)
        .then((result) => {
          console.log('You have been successfully logged in!');
        }).catch((error) => {
          console.log('Error in authLogin: ' + error);
        });
  }

  async signOut(loggedIn: boolean) {
    await this.Auth.auth.signOut().then((result) => {
      console.log('Signed out!');
      loggedIn = false;
    }, (error) => {
      console.log(error);
    });
  }
}
