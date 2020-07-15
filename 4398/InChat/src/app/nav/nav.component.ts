import {Component, OnInit} from '@angular/core';
import {AngularFirestore, AngularFirestoreDocument, AngularFirestoreCollection} from '@angular/fire/firestore';
import {AuthService} from '../services/auth.service';
import {UserService} from '../services/user.service';
import {SettingsService} from '../services/settings.service';
import {User} from '../models/user.model';


@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss', '../sign-in/sign-in.component.scss'],
})
export class NavComponent implements OnInit {
  loggedIn = false;
  currentUser: any;
  userRef = this.db.collection('users');
  user: any;
  showAlert = false;


  constructor(
    private afAuth: AuthService,
    private userService: UserService,
    private db: AngularFirestore,
    public settings: SettingsService) { }

  ngOnInit() {
    this.afAuth.Auth.auth.onAuthStateChanged(async () => {
      let add;
      if (this.afAuth.Auth.auth.currentUser === null) {
        this.loggedIn = false;
        console.log('No user');
        return;
      } else {
        this.loggedIn = true;
        this.currentUser = this.afAuth.Auth.auth.currentUser;
        add = await this.userService.doesUserExist(this.currentUser.uid);
        this.userService.getUser(this.currentUser.uid).subscribe((user) => {
          this.userService.setCurrentUser(user as User);
          console.log(this.userService.getCurrentUser().userDB.language);
        });
      }
      if (add) {
        console.log('NOT added');
      } else if (!add) {
        console.log('Added');
        this.userService.createUser(this.currentUser.uid);
      }
    });
  }

  async deleteWrapper() {
    const uid = this.afAuth.Auth.auth.currentUser.uid;
    if (this.loggedIn === true) {
      await this.afAuth.signOut(true).then(() => {
        return this.userService.deleteUser(uid);
      }).then(() => {

      });
    }
  }

  async editWrapper(uName: string) {
    await this.userService.editUsername(uName);
    console.log('Success!');
  }
}
