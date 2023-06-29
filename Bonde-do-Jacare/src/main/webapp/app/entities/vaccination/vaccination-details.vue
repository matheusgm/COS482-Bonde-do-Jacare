<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="vaccination">
        <h2 class="jh-entity-heading" data-cy="vaccinationDetailsHeading">
          <span v-text="$t('bondeDoJacareApp.vaccination.detail.title')">Vaccination</span> {{ vaccination.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('bondeDoJacareApp.vaccination.name')">Name</span>
          </dt>
          <dd>
            <span>{{ vaccination.name }}</span>
          </dd>
          <dt>
            <span v-text="$t('bondeDoJacareApp.vaccination.age')">Age</span>
          </dt>
          <dd>
            <span>{{ vaccination.age }}</span>
          </dd>
          <dt>
            <span v-text="$t('bondeDoJacareApp.vaccination.job')">Job</span>
          </dt>
          <dd>
            <span>{{ vaccination.job }}</span>
          </dd>
          <dt>
            <span v-text="$t('bondeDoJacareApp.vaccination.phoneNumber')">Phone Number</span>
          </dt>
          <dd>
            <span>{{ vaccination.phoneNumber }}</span>
          </dd>
          <dt>
            <span v-text="$t('bondeDoJacareApp.vaccination.address')">Address</span>
          </dt>
          <dd>
            <span>{{ vaccination.address }}</span>
          </dd>
          <dt>
            <span v-text="$t('bondeDoJacareApp.vaccination.dateAndTime')">Date And Time</span>
          </dt>
          <dd>
            <span>{{ vaccination.dateAndTime }}</span>
          </dd>
          <dt>
            <span v-text="$t('bondeDoJacareApp.vaccination.vaccineType')">Vaccine Type</span>
          </dt>
          <dd>
            <span>{{ vaccination.vaccineType }}</span>
          </dd>
          <dt>
            <span v-text="$t('bondeDoJacareApp.vaccination.applicator')">Applicator</span>
          </dt>
          <dd>
            <span>{{ vaccination.applicator }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./vaccination-details.component.ts"></script>
