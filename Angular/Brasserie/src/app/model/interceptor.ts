import { Observable } from 'rxjs';
import { AuthentificationService } from './../services/authentification.service';
import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class Interceptor implements HttpInterceptor {
  constructor(private authService: AuthentificationService) {}

  intercept(
    request: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    if (this.authService.isAutenticated()) {
      request = request.clone({
        headers: request.headers.append(
          'Authorization',
          localStorage.getItem('token')!
        ),
      });
    }
    return next.handle(request);
  }
}
