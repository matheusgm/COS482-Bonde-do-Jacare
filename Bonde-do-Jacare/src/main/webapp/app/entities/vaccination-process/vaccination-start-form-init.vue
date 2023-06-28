<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="bondeDoJacareApp.vaccinationStartForm.home.createOrEditLabel"
          data-cy="VaccinationStartFormCreateUpdateHeading"
          v-text="$t('bondeDoJacareApp.vaccinationStartForm.home.createOrEditLabel')"
        >
          Create or edit a VaccinationStartForm
        </h2>
        <div v-if="vaccinationProcess.processInstance">
          <akip-show-process-definition :processDefinition="vaccinationProcess.processInstance.processDefinition">
            <template v-slot:body>
              <hr />
              <div v-if="vaccinationProcess.vaccination">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('bondeDoJacareApp.vaccinationStartForm.name')"
                    for="vaccination-start-form-name"
                    >Name</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="name"
                    id="vaccination-start-form-name"
                    data-cy="name"
                    :class="{
                      valid: !$v.vaccinationProcess.vaccination.name.$invalid,
                      invalid: $v.vaccinationProcess.vaccination.name.$invalid,
                    }"
                    v-model="$v.vaccinationProcess.vaccination.name.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('bondeDoJacareApp.vaccinationStartForm.age')"
                    for="vaccination-start-form-age"
                    >Age</label
                  >
                  <input
                    type="number"
                    class="form-control"
                    name="age"
                    id="vaccination-start-form-age"
                    data-cy="age"
                    :class="{
                      valid: !$v.vaccinationProcess.vaccination.age.$invalid,
                      invalid: $v.vaccinationProcess.vaccination.age.$invalid,
                    }"
                    v-model.number="$v.vaccinationProcess.vaccination.age.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('bondeDoJacareApp.vaccinationStartForm.job')"
                    for="vaccination-start-form-job"
                    >Job</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="job"
                    id="vaccination-start-form-job"
                    data-cy="job"
                    :class="{
                      valid: !$v.vaccinationProcess.vaccination.job.$invalid,
                      invalid: $v.vaccinationProcess.vaccination.job.$invalid,
                    }"
                    v-model="$v.vaccinationProcess.vaccination.job.$model"
                  />
                </div>
              </div>
            </template>
          </akip-show-process-definition>
          <br />
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.vaccinationProcess.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;<span>Start</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./vaccination-start-form-init.component.ts"></script>
