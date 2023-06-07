<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="taskContext.taskInstance">
        <h2 id="page-heading" data-cy="TaskInstanceHeading">
          <span v-text="$t('bondeDoJacareApp.taskInstance.execute.title')" id="task-instance-heading">Task Execution</span>
        </h2>
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bondeDoJacareApp.taskApplication.name')" for="task-application-name"
                >Name</label
              >
              <input
                type="text"
                class="form-control"
                name="name"
                id="task-application-name"
                readonly
                data-cy="name"
                :class="{
                  valid: !$v.taskContext.vaccinationProcess.vaccination.name.$invalid,
                  invalid: $v.taskContext.vaccinationProcess.vaccination.name.$invalid,
                }"
                v-model="$v.taskContext.vaccinationProcess.vaccination.name.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bondeDoJacareApp.taskApplication.birthDate')" for="task-application-birthDate"
                >Birth Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-application-birthDate"
                  readonly
                  data-cy="birthDate"
                  type="text"
                  class="form-control"
                  name="birthDate"
                  :class="{
                    valid: !$v.taskContext.vaccinationProcess.vaccination.birthDate.$invalid,
                    invalid: $v.taskContext.vaccinationProcess.vaccination.birthDate.$invalid,
                  }"
                  v-model="$v.taskContext.vaccinationProcess.vaccination.birthDate.$model"
                />
              </b-input-group>
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bondeDoJacareApp.taskApplication.job')" for="task-application-job">Job</label>
              <input
                type="text"
                class="form-control"
                name="job"
                id="task-application-job"
                readonly
                data-cy="job"
                :class="{
                  valid: !$v.taskContext.vaccinationProcess.vaccination.job.$invalid,
                  invalid: $v.taskContext.vaccinationProcess.vaccination.job.$invalid,
                }"
                v-model="$v.taskContext.vaccinationProcess.vaccination.job.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('bondeDoJacareApp.taskApplication.phoneNumber')"
                for="task-application-phoneNumber"
                >Phone Number</label
              >
              <input
                type="text"
                class="form-control"
                name="phoneNumber"
                id="task-application-phoneNumber"
                readonly
                data-cy="phoneNumber"
                :class="{
                  valid: !$v.taskContext.vaccinationProcess.vaccination.phoneNumber.$invalid,
                  invalid: $v.taskContext.vaccinationProcess.vaccination.phoneNumber.$invalid,
                }"
                v-model="$v.taskContext.vaccinationProcess.vaccination.phoneNumber.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bondeDoJacareApp.taskApplication.address')" for="task-application-address"
                >Address</label
              >
              <input
                type="text"
                class="form-control"
                name="address"
                id="task-application-address"
                readonly
                data-cy="address"
                :class="{
                  valid: !$v.taskContext.vaccinationProcess.vaccination.address.$invalid,
                  invalid: $v.taskContext.vaccinationProcess.vaccination.address.$invalid,
                }"
                v-model="$v.taskContext.vaccinationProcess.vaccination.address.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('bondeDoJacareApp.taskApplication.dateAndTime')"
                for="task-application-dateAndTime"
                >Date And Time</label
              >
              <b-input-group class="mb-3">
                <b-input-group-prepend>
                  <b-form-datepicker
                    aria-controls="task-application-dateAndTime"
                    v-model="$v.taskContext.vaccinationProcess.vaccination.dateAndTime.$model"
                    name="dateAndTime"
                    class="form-control"
                    :locale="currentLanguage"
                    button-only
                    today-button
                    reset-button
                    close-button
                  >
                  </b-form-datepicker>
                </b-input-group-prepend>

                <b-form-input
                  id="task-application-dateAndTime"
                  data-cy="dateAndTime"
                  type="text"
                  class="form-control"
                  name="dateAndTime"
                  :class="{
                    valid: !$v.taskContext.vaccinationProcess.vaccination.dateAndTime.$invalid,
                    invalid: $v.taskContext.vaccinationProcess.vaccination.dateAndTime.$invalid,
                  }"
                  v-model="$v.taskContext.vaccinationProcess.vaccination.dateAndTime.$model"
                />
              </b-input-group>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('bondeDoJacareApp.taskApplication.vaccineType')"
                for="task-application-vaccineType"
                >Vaccine Type</label
              >
              <input
                type="text"
                class="form-control"
                name="vaccineType"
                id="task-application-vaccineType"
                data-cy="vaccineType"
                :class="{
                  valid: !$v.taskContext.vaccinationProcess.vaccination.vaccineType.$invalid,
                  invalid: $v.taskContext.vaccinationProcess.vaccination.vaccineType.$invalid,
                }"
                v-model="$v.taskContext.vaccinationProcess.vaccination.vaccineType.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bondeDoJacareApp.taskApplication.applicator')" for="task-application-applicator"
                >Applicator</label
              >
              <input
                type="text"
                class="form-control"
                name="applicator"
                id="task-application-applicator"
                data-cy="applicator"
                :class="{
                  valid: !$v.taskContext.vaccinationProcess.vaccination.applicator.$invalid,
                  invalid: $v.taskContext.vaccinationProcess.vaccination.applicator.$invalid,
                }"
                v-model="$v.taskContext.vaccinationProcess.vaccination.applicator.$model"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <button type="submit" v-on:click.prevent="complete()" class="btn btn-success" data-cy="complete">
          <font-awesome-icon icon="check-circle"></font-awesome-icon>&nbsp;Complete
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-application-execute.component.ts"></script>
