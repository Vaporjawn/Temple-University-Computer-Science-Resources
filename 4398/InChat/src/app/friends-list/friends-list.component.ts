import {Component, OnInit} from '@angular/core';
import {AuthService} from '../services/auth.service';
import {auth} from 'firebase/app';
import {UserService} from '../services/user.service';
import {FriendsService} from '../services/friends.service';
import {HttpClient} from '@angular/common/http';
import {AngularFirestore, AngularFirestoreDocument} from '@angular/fire/firestore';
import {User} from '../models/user.model';


@Component({
  selector: 'app-friends-list',
  templateUrl: './friends-list.component.html',
  styleUrls: ['./friends-list.component.scss'],
})
export class FriendsListComponent implements OnInit {
  constructor(public afAuth: AuthService, public friendsService: FriendsService, public userService: UserService) { }
    uid;
    uName;


    ngOnInit() {
    }
}
