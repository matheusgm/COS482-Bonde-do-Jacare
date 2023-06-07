import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const Vaccination = () => import('@/entities/vaccination/vaccination.vue');
// prettier-ignore
const VaccinationDetails = () => import('@/entities/vaccination/vaccination-details.vue');
// prettier-ignore
const VaccinationProcess_TaskApplicationDetails = () => import('@/entities/vaccination-process/task-application/task-application-details.vue');
// prettier-ignore
const VaccinationProcess_TaskApplicationExecute = () => import('@/entities/vaccination-process/task-application/task-application-execute.vue');
// prettier-ignore
const VaccinationProcess_TaskRegistrationDetails = () => import('@/entities/vaccination-process/task-registration/task-registration-details.vue');
// prettier-ignore
const VaccinationProcess_TaskRegistrationExecute = () => import('@/entities/vaccination-process/task-registration/task-registration-execute.vue');
// prettier-ignore
const VaccinationProcessDetails = () => import('@/entities/vaccination-process/vaccination-process-details.vue');
// prettier-ignore
const VaccinationProcessList = () => import('@/entities/vaccination-process/vaccination-process-list.vue');
// prettier-ignore
const VaccinationStartFormInit = () => import('@/entities/vaccination-process/vaccination-start-form-init.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/vaccination',
    name: 'Vaccination',
    component: Vaccination,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/vaccination/:vaccinationId/view',
    name: 'VaccinationView',
    component: VaccinationDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/VaccinationProcess/task/Application/:taskInstanceId/view',
    name: 'VaccinationProcess_TaskApplicationDetails',
    component: VaccinationProcess_TaskApplicationDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/VaccinationProcess/task/Application/:taskInstanceId/execute',
    name: 'VaccinationProcess_TaskApplicationExecute',
    component: VaccinationProcess_TaskApplicationExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/VaccinationProcess/task/Registration/:taskInstanceId/view',
    name: 'VaccinationProcess_TaskRegistrationDetails',
    component: VaccinationProcess_TaskRegistrationDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/VaccinationProcess/task/Registration/:taskInstanceId/execute',
    name: 'VaccinationProcess_TaskRegistrationExecute',
    component: VaccinationProcess_TaskRegistrationExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/VaccinationProcess/instance/:processInstanceId/view',
    name: 'VaccinationProcessView',
    component: VaccinationProcessDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/VaccinationProcess/instances',
    name: 'VaccinationProcessList',
    component: VaccinationProcessList,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/VaccinationProcess/init',
    name: 'VaccinationStartFormInit',
    component: VaccinationStartFormInit,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
