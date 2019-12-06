import { ProjectComponent } from '../../project/project.component';
import { Routes } from '@angular/router';
import {CreateProjectComponent} from "../../project/create-project/create-project.component";


export const ProjectLayoutRoutes: Routes = [
    { path: 'userID',      component: ProjectComponent, children:[
        { path: 'createProject',      component: CreateProjectComponent }

      ] },
];
