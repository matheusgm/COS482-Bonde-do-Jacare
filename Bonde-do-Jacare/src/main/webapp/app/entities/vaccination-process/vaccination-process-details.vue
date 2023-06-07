<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="vaccinationProcess.processInstance">
        <h2 class="jh-entity-heading" data-cy="vaccinationProcessDetailsHeading">
          <span v-text="$t('bondeDoJacareApp.vaccinationProcess.detail.title')">VaccinationProcess</span> {{ vaccinationProcess.id }}
        </h2>
        <akip-show-process-instance :processInstance="vaccinationProcess.processInstance">
          <template v-slot:title>
            <span v-text="$t('bondeDoJacareApp.vaccinationProcess.detail.title')">VaccinationProcess</span> #{{ vaccinationProcess.id }}
          </template>
          <template v-slot:details>
            <div class="card" v-if="vaccinationProcess.vaccination">
              <h5 class="card-header">
                <span class="title"> Vaccination #{{ vaccinationProcess.vaccination.id }} </span>
              </h5>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bondeDoJacareApp.vaccinationProcess.name')">name</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="name"
                    id="vaccination-name"
                    data-cy="name"
                    v-model="vaccinationProcess.vaccination.name"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bondeDoJacareApp.vaccinationProcess.birthDate')">birthDate</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="birthDate"
                    id="vaccination-birthDate"
                    data-cy="birthDate"
                    v-model="vaccinationProcess.vaccination.birthDate"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bondeDoJacareApp.vaccinationProcess.job')">job</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="job"
                    id="vaccination-job"
                    data-cy="job"
                    v-model="vaccinationProcess.vaccination.job"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bondeDoJacareApp.vaccinationProcess.phoneNumber')">phoneNumber</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="phoneNumber"
                    id="vaccination-phoneNumber"
                    data-cy="phoneNumber"
                    v-model="vaccinationProcess.vaccination.phoneNumber"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bondeDoJacareApp.vaccinationProcess.address')">address</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="address"
                    id="vaccination-address"
                    data-cy="address"
                    v-model="vaccinationProcess.vaccination.address"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bondeDoJacareApp.vaccinationProcess.dateAndTime')">dateAndTime</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="dateAndTime"
                    id="vaccination-dateAndTime"
                    data-cy="dateAndTime"
                    v-model="vaccinationProcess.vaccination.dateAndTime"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bondeDoJacareApp.vaccinationProcess.vaccineType')">vaccineType</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="vaccineType"
                    id="vaccination-vaccineType"
                    data-cy="vaccineType"
                    v-model="vaccinationProcess.vaccination.vaccineType"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bondeDoJacareApp.vaccinationProcess.applicator')">applicator</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="applicator"
                    id="vaccination-applicator"
                    data-cy="applicator"
                    v-model="vaccinationProcess.vaccination.applicator"
                  />
                </div>
              </div>
            </div>
          </template>
        </akip-show-process-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./vaccination-process-details.component.ts"></script>
