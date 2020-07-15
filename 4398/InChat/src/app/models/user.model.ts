import {Time} from '@angular/common';

export interface User {
    uName: string;
    email: string;
    status: string;
    lastSeen: Time;
    language: string;
    friends?: (string)[] | null;
    chats?: (string)[] | null;
}
