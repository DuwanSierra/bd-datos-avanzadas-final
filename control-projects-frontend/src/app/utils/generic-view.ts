import { AfterViewInit, Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { GenericConstants } from './general.constants';

@Injectable({
  providedIn: 'root',
})
export class GenericView implements AfterViewInit{
  public GENERAL_CONSTANTS = GenericConstants;
  public isEdit: boolean = false;

  viewFormGroup: FormGroup = new FormGroup({});

  constructor(public activatedRoute: ActivatedRoute) {
  }

  ngAfterViewInit(): void {
    this.getParams();
    this.getData();
  }

  getData(){
    this.activatedRoute.data.subscribe((data)=>{
      if(data && data['isEdit']){
        this.isEdit = true;
        this.afterCheckIsEditMode();
      }
    })
  }

  getParams() {
    this.activatedRoute.params.subscribe((params: any) => {
      this.afterLoadParams(params);
    });
  }

  afterCheckIsEditMode(){}

  afterLoadParams(data: any) {}
}
