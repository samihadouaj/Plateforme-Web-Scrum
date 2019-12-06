import { ProjectLayoutRoutes } from './project-layout.routing';
import { SidebarProjectComponent } from '../../project/sidebar-project/sidebar-project.component';
import { ProjectComponent } from '../../project/project.component';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {CreateProjectComponent} from "../../project/create-project/create-project.component";
import {MatFormFieldModule} from "@angular/material/form-field";

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(ProjectLayoutRoutes),

    FormsModule,
    NgbModule,
    MatFormFieldModule
  ],
  exports: [
    SidebarProjectComponent
  ],
  declarations: [

    ProjectComponent,
    SidebarProjectComponent,
    CreateProjectComponent
  ]
})

export class ProjectLayoutModule {}
