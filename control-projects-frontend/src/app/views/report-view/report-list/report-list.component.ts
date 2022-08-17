import { Component, OnInit } from '@angular/core';
import { ProfesorManagerService } from 'src/app/managers/profesor-manager/profesor-manager.service';
import { ReportManagerService } from 'src/app/managers/report-manager/report-manager.service';
import { ProfessorRequest } from 'src/app/managers/request-dto/professor.request';
import { ProjectsByProfessorView } from 'src/app/managers/request-dto/projects-by-professor.view';
import { Utils } from 'src/app/utils/utils';
import { Customer } from '../../../interfaces/customer-interface';

@Component({
  selector: 'app-report-list',
  templateUrl: './report-list.component.html',
  styleUrls: ['./report-list.component.scss'],
})
export class ReportListComponent implements OnInit {
  title = 'REPORTES';

  profesorDto?: ProfessorRequest;

  data = {
    labels: ['A', 'B', 'C'],
    datasets: [
      {
        data: [300, 50, 100],
        backgroundColor: ['#42A5F5', '#66BB6A', '#FFA726'],
        hoverBackgroundColor: ['#64B5F6', '#81C784', '#FFB74D'],
      },
    ],
  };

  constructor(
    public profesorManager: ProfesorManagerService,
    public reportsManager: ReportManagerService
  ) {}

  ngOnInit(): void {}

  getReportProjectByProfessor() {
    if (this.profesorDto?.cedulaProfesor) {
      this.reportsManager
        .getProjectByCC(this.profesorDto?.cedulaProfesor)
        .subscribe((res) => {
          this.generateDataReportProjectByProfessor(res);
        });
    }
  }

  generateDataReportProjectByProfessor(report: ProjectsByProfessorView[]) {
    let labels: string[] = report.map(
      (item) => `${item.codigoProyecto} - ${item.nombreProyecto}`
    );
    let data: any[] = [];
    let backgroundColors: any[] = [];
    let hoverBackgroundColor: any[] = [];
    report.forEach((item) => {
      data.push(labels.length / 100);
      backgroundColors.push(Utils.generateRamdomColor());
      hoverBackgroundColor.push(Utils.generateRamdomColor());
    });
    if (labels.length > 0) {
      this.data = {
        labels: labels,
        datasets: [
          {
            data: data,
            backgroundColor: backgroundColors,
            hoverBackgroundColor: hoverBackgroundColor,
          },
        ],
      };
    }
  }
}
