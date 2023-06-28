<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <h2 id="page-heading" data-cy="TaskInstanceHeading">
        <span v-text="$t('bondeDoJacareApp.taskInstance.details.title')" id="task-instance-heading">Task Details</span>
      </h2>
      <div v-if="taskContext.taskInstance">
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bondeDoJacareApp.taskApplication.name')">name</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="name"
                id="vaccination-name"
                data-cy="name"
                v-model="taskContext.vaccinationProcess.vaccination.name"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bondeDoJacareApp.taskApplication.age')">age</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="age"
                id="vaccination-age"
                data-cy="age"
                v-model="taskContext.vaccinationProcess.vaccination.age"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bondeDoJacareApp.taskApplication.job')">job</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="job"
                id="vaccination-job"
                data-cy="job"
                v-model="taskContext.vaccinationProcess.vaccination.job"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bondeDoJacareApp.taskApplication.phoneNumber')">phoneNumber</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="phoneNumber"
                id="vaccination-phoneNumber"
                data-cy="phoneNumber"
                v-model="taskContext.vaccinationProcess.vaccination.phoneNumber"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bondeDoJacareApp.taskApplication.address')">address</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="address"
                id="vaccination-address"
                data-cy="address"
                v-model="taskContext.vaccinationProcess.vaccination.address"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bondeDoJacareApp.taskApplication.dateAndTime')">dateAndTime</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="dateAndTime"
                id="vaccination-dateAndTime"
                data-cy="dateAndTime"
                v-model="taskContext.vaccinationProcess.vaccination.dateAndTime"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bondeDoJacareApp.taskApplication.vaccineType')">vaccineType</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="vaccineType"
                id="vaccination-vaccineType"
                data-cy="vaccineType"
                v-model="taskContext.vaccinationProcess.vaccination.vaccineType"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bondeDoJacareApp.taskApplication.applicator')">applicator</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="applicator"
                id="vaccination-applicator"
                data-cy="applicator"
                v-model="taskContext.vaccinationProcess.vaccination.applicator"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/VaccinationProcess/task/Application/${taskContext.taskInstance.id}/execute`"
          tag="button"
          class="btn btn-primary"
          data-cy="entityDetailsButton"
        >
          <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;Execute
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-application-details.component.ts"></script>
