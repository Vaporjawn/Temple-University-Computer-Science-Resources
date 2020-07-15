import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ChatsComponent} from './chats/chats.component';
import {FriendsListComponent} from './friends-list/friends-list.component';
import {HomeComponent} from './home/home.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'chat', component: ChatsComponent},
  {path: 'home', component: HomeComponent},
  {path: ' ', redirectTo: '/home'},
  {path: 'friends', component: FriendsListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
