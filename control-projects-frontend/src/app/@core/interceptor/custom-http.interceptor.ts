import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
} from '@angular/common/http';
import { catchError, map, Observable } from 'rxjs';
import { CustomSpinnerService } from '../spinner/custom-spinner.service';

@Injectable()
export class CustomHttpInterceptor implements HttpInterceptor {
  constructor(private customSpinnerService: CustomSpinnerService) {}

  intercept(
    request: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    return next
      .handle(request)
      .pipe(
        catchError((err) => {
          this.customSpinnerService.closeSpinner();
          return err;
        })
      )
      .pipe(
        map((evt: any) => {
          this.customSpinnerService.openSpinner();
          return evt;
        })
      );
  }
}
