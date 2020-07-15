import {Injectable} from '@angular/core';
import {AngularFirestore, AngularFirestoreDocument} from '@angular/fire/firestore';
import {AuthService} from './auth.service';
import {User} from '../models/user.model';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private db: AngularFirestore, private afAuth: AuthService) { }
  dbRef = this.db.collection('users');
  currentUser;
  users: AngularFirestoreDocument<User>;

  async deleteUser(uId: string) {
    await this.db.collection('users').doc(uId).delete();
    return true;
  }

  doesUserExist(uId: string) {
    let docExist: boolean;
    const docRef = this.dbRef.doc(uId);
    docRef.get().toPromise().then((doc) => {
      if (doc.exists) {
        // console.log('Document data:', doc.data());
        return true;
      } else {
        // doc.data() will be undefined in this case
        // console.log('No such document!');
        return true;
      }
    }).catch((error) => {
      console.log('Error getting document:', error);
    });
  }

  createUser(uId: string) {
    if (this.afAuth.Auth.auth.currentUser) {
      this.dbRef.doc(this.afAuth.Auth.auth.currentUser.uid).valueChanges().subscribe((data) => {
        const user = data;
        if (user === undefined) {
          const userDB: User = {
            uName: this.afAuth.Auth.auth.currentUser.displayName,
            email: this.afAuth.Auth.auth.currentUser.email,
            status: 'offline',
            lastSeen: null,
            language: 'en',
            friends: [],
            chats: [],
          };
          this.dbRef.doc(uId).set({userDB});
          return;
        }
      });
    }
  }

  editUsername(newName: string) {
    this.db.collection('users').doc(this.afAuth.Auth.auth.currentUser.uid).update(
        {'userDB.uName': newName}).then(() => console.log('field updated'));
  }

  getUser(userId) {
    return this.db.collection('users').doc(userId).valueChanges();
  }

  getUserFriendsUname(){
    let friendUname: string[] = []
    let friendIDs: string[] = this.getCurrentUser().userDB.friends;
    for (let fID of friendIDs){
      console.log(fID);
      //this.getUser(fID).subscribe(data as User => {console.log(data.uName)});
    }
    return this.getCurrentUser();
  }

  getCurrentUser() {
    return this.currentUser;
  }

  setCurrentUser(user: User) {
    this.currentUser = user;
    // console.log(this.currentUser.userDB.language);
  }
}
