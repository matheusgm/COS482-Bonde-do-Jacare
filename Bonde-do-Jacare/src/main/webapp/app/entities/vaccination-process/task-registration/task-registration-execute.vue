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
              <label class="form-control-label" v-text="$t('bondeDoJacareApp.taskRegistration.name')" for="task-registration-name"
                >Name</label
              >
              <input
                type="text"
                class="form-control"
                name="name"
                id="task-registration-name"
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
              <label class="form-control-label" v-text="$t('bondeDoJacareApp.taskRegistration.birthDate')" for="task-registration-birthDate"
                >Birth Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-registration-birthDate"
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
              <label class="form-control-label" v-text="$t('bondeDoJacareApp.taskRegistration.job')" for="task-registration-job">Job</label>
              <input
                type="text"
                class="form-control"
                name="job"
                id="task-registration-job"
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
                v-text="$t('bondeDoJacareApp.taskRegistration.phoneNumber')"
                for="task-registration-phoneNumber"
                >Phone Number</label
              >
              <input
                type="text"
                class="form-control"
                name="phoneNumber"
                id="task-registration-phoneNumber"
                data-cy="phoneNumber"
                :class="{
                  valid: !$v.taskContext.vaccinationProcess.vaccination.phoneNumber.$invalid,
                  invalid: $v.taskContext.vaccinationProcess.vaccination.phoneNumber.$invalid,
                }"
                v-model="$v.taskContext.vaccinationProcess.vaccination.phoneNumber.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bondeDoJacareApp.taskRegistration.address')" for="task-registration-address"
                >Address</label
              >
              <input
                type="text"
                class="form-control"
                name="address"
                id="task-registration-address"
                data-cy="address"
                :class="{
                  valid: !$v.taskContext.vaccinationProcess.vaccination.address.$invalid,
                  invalid: $v.taskContext.vaccinationProcess.vaccination.address.$invalid,
                }"
                v-model="$v.taskContext.vaccinationProcess.vaccination.address.$model"
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

<script lang="ts" src="./task-registration-execute.component.ts"></script>
