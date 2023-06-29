<template>
  <div>
    <h2 id="page-heading" data-cy="VaccinationHeading">
      <span v-text="$t('bondeDoJacareApp.vaccination.home.title')" id="vaccination-heading">Vaccinations</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('bondeDoJacareApp.vaccination.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && vaccinations && vaccinations.length === 0">
      <span v-text="$t('bondeDoJacareApp.vaccination.home.notFound')">No vaccinations found</span>
    </div>
    <div class="table-responsive" v-if="vaccinations && vaccinations.length > 0">
      <table class="table table-striped" aria-describedby="vaccinations">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('bondeDoJacareApp.vaccination.name')">Name</span></th>
            <th scope="row"><span v-text="$t('bondeDoJacareApp.vaccination.age')">Age</span></th>
            <th scope="row"><span v-text="$t('bondeDoJacareApp.vaccination.job')">Job</span></th>
            <th scope="row"><span v-text="$t('bondeDoJacareApp.vaccination.phoneNumber')">Phone Number</span></th>
            <th scope="row"><span v-text="$t('bondeDoJacareApp.vaccination.address')">Address</span></th>
            <th scope="row"><span v-text="$t('bondeDoJacareApp.vaccination.dateAndTime')">Date And Time</span></th>
            <th scope="row"><span v-text="$t('bondeDoJacareApp.vaccination.vaccineType')">Vaccine Type</span></th>
            <th scope="row"><span v-text="$t('bondeDoJacareApp.vaccination.applicator')">Applicator</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="vaccination in vaccinations" :key="vaccination.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'VaccinationView', params: { vaccinationId: vaccination.id } }">{{ vaccination.id }}</router-link>
            </td>
            <td>{{ vaccination.name }}</td>
            <td>{{ vaccination.age }}</td>
            <td>{{ vaccination.job }}</td>
            <td>{{ vaccination.phoneNumber }}</td>
            <td>{{ vaccination.address }}</td>
            <td>{{ vaccination.dateAndTime }}</td>
            <td>{{ vaccination.vaccineType }}</td>
            <td>{{ vaccination.applicator }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'VaccinationView', params: { vaccinationId: vaccination.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="bondeDoJacareApp.vaccination.delete.question" data-cy="vaccinationDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-vaccination-heading" v-text="$t('bondeDoJacareApp.vaccination.delete.question', { id: removeId })">
          Are you sure you want to delete this Vaccination?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-vaccination"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeVaccination()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./vaccination.component.ts"></script>
