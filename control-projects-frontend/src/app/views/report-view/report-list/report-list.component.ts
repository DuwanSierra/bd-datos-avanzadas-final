import { Component, OnInit } from '@angular/core';
import { Customer } from '../../../interfaces/customer-interface';


@Component({
  selector: 'app-report-list',
  templateUrl: './report-list.component.html',
  styleUrls: ['./report-list.component.scss'],
  styles: [`
  :host ::ng-deep .p-datatable .p-datatable-thead > tr > th {
      position: -webkit-sticky;
      position: sticky;
      top: 5rem;
  }

  .layout-news-active :host ::ng-deep .p-datatable tr > th {
      top: 7rem;
  }
`]
})
export class ReportListComponent implements OnInit {

  customers: Customer[] = [
    {
      "id": 1000,
      "name": "James Butt",
      "country": {
        "name": "Algeria",
        "code": "dz"
      },
      "company": "Benton, John B Jr",
      "date": "2015-09-13",
      "status": "unqualified",
      "representative": {
        "name": "Ioni Bowcher",
        "image": "ionibowcher.png"
      }
    },
    {
      "id": 1001,
      "name": "Josephine Darakjy",
      "country": {
        "name": "Egypt",
        "code": "eg"
      },
      "company": "Chanay, Jeffrey A Esq",
      "date": "2019-02-09",
      "status": "proposal",
      "representative": {
        "name": "Amy Elsner",
        "image": "amyelsner.png"
      }
    },
    {
      "id": 1002,
      "name": "Art Venere",
      "country": {
        "name": "Panama",
        "code": "pa"
      },
      "company": "Chemel, James L Cpa",
      "date": "2017-05-13",
      "status": "qualified",

      "representative": {
        "name": "Asiya Javayant",
        "image": "asiyajavayant.png"
      }
    },
    {
      "id": 1003,
      "name": "Lenna Paprocki",
      "country": {
        "name": "Slovenia",
        "code": "si"
      },
      "company": "Feltz Printing Service",
      "date": "2020-09-15",
      "status": "new",

      "representative": {
        "name": "Xuxue Feng",
        "image": "xuxuefeng.png"
      }
    },
    {
      "id": 1004,
      "name": "Donette Foller",
      "country": {
        "name": "South Africa",
        "code": "za"
      },
      "company": "Printing Dimensions",
      "date": "2016-05-20",
      "status": "proposal",
      "representative": {
        "name": "Asiya Javayant",
        "image": "asiyajavayant.png"
      }
    }

  ]
  title = 'REPORTES';

  constructor() { }

  ngOnInit(): void {

  }




}



