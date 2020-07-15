import {Time} from '@angular/common';

export interface Message {
    userId: string;
    uName: string;
    chatId: string;
    timeSent: Date;
    originalLanguage: string;
    originalMessage: string;
    isTextBased: boolean;
}
