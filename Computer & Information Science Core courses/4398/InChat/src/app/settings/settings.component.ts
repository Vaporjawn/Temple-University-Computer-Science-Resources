import {Component, OnInit} from '@angular/core';
import {AngularFirestore} from '@angular/fire/firestore';
import {AuthService} from '../services/auth.service';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.scss'],
})
export class SettingsComponent implements OnInit {
  constructor(private db: AngularFirestore, private afAuth: AuthService) { }

  codes: string[] = ['en', 'es', 'fr', 'it', 'ko', 'ru'];
  uid = this.afAuth.Auth.auth.currentUser.uid;

  ngOnInit() {
  }

  changeLanguage(langCode: string) {
    if (this.codes.includes(langCode)) {
      const collection = this.db.collection('users').doc(this.uid);
      collection.update(
          {'user.language': langCode}).then(() => console.log('field updated'));
    }
  }
}
