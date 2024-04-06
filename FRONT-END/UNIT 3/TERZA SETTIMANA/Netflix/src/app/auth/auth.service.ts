import { Injectable } from '@angular/core';

// http
import { HttpClient } from '@angular/common/http';

//interfaces
import { SignUp } from '../models/sign-up';
import { Auth } from '../models/auth';

//enviroment
import { environment } from 'src/environments/environment.development';

// other imports
import { BehaviorSubject, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Router } from '@angular/router';

//jwt
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
    providedIn: 'root',
})
export class AuthService {
    //FIXME: make sure u check this part clearly and make comments. eventually comment also the enviroment
    apiURL = environment.apiURL;
    jwt = new JwtHelperService; 

    private authSub = new BehaviorSubject<Auth | null>(null);
    user$ = this.authSub.asObservable();
    _expirationTime: any;

    constructor(private http: HttpClient, private router: Router) {}

    //dati che devono nascere e morire qui per il metodo di login
    login(data: { email: string; password: string }) {
        return this.http.post<Auth>(`${this.apiURL}signin`, data).pipe(
            tap((data) => {
                console.log('Login info:', data);
                this.handleLoginSuccess(data);
            }),
            catchError(this.handleError)
        );
    }

    //metodo per il sign up
    signup(data: SignUp) {
        return this.http
            .post(`${this.apiURL}signup`, data)
            .pipe(catchError(this.handleError));
    }

    //metodo per il log out
    logout() {
        this.authSub.next(null);
        localStorage.removeItem('user');
        this.router.navigate(['/']);
    }

    restore() {
        const userInfo = localStorage.getItem('user');
        if (userInfo) {
            const user: Auth = JSON.parse(userInfo);
            this.authSub.next(user);
            this.autoLogout(user);
        }
    }

    //TODO: CHECK THIS!!! and understand it
    //log out automatically after the expiration date
    autoLogout(user: Auth) {
        const tokenExpirationDate = this.jwt.getTokenExpirationDate(
            user.accessToken
        );
        if (tokenExpirationDate) {
            const millisecondsExp =
                tokenExpirationDate.getTime() - new Date().getTime();
            if (millisecondsExp > 0) {
                this._expirationTime = setTimeout(() => {
                    this.logout();
                }, millisecondsExp);
            }
        }
    }

    //FIXME: make sure this errors actually do send an alert and have the right errors in it
    public handleError(error: any) {
        let errorMessage = 'Errore nella chiamata';
        if (error.error) {
            switch (error.error) {
                case 'Email already exists':
                    errorMessage = 'Utente già presente';
                    alert(errorMessage);
                    break;
                case 'Incorrect password':
                    errorMessage = 'Password errata';
                    alert(errorMessage);
                    break;
                case 'Cannot find user':
                    errorMessage = 'Utente non trovato';
                    alert(errorMessage);
                    break;
                default:
                    break;
            }
        }
        console.error(errorMessage);
        return throwError(errorMessage);
    }

    private handleLoginSuccess(data: Auth) {
        this.authSub.next(data);
        localStorage.setItem('user', JSON.stringify(data));
        this.autoLogout(data);
    }
}

