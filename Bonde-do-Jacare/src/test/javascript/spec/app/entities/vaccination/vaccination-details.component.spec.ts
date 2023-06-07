/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import VaccinationDetailComponent from '@/entities/vaccination/vaccination-details.vue';
import VaccinationClass from '@/entities/vaccination/vaccination-details.component';
import VaccinationService from '@/entities/vaccination/vaccination.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Vaccination Management Detail Component', () => {
    let wrapper: Wrapper<VaccinationClass>;
    let comp: VaccinationClass;
    let vaccinationServiceStub: SinonStubbedInstance<VaccinationService>;

    beforeEach(() => {
      vaccinationServiceStub = sinon.createStubInstance<VaccinationService>(VaccinationService);

      wrapper = shallowMount<VaccinationClass>(VaccinationDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { vaccinationService: () => vaccinationServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundVaccination = { id: 123 };
        vaccinationServiceStub.find.resolves(foundVaccination);

        // WHEN
        comp.retrieveVaccination(123);
        await comp.$nextTick();

        // THEN
        expect(comp.vaccination).toBe(foundVaccination);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundVaccination = { id: 123 };
        vaccinationServiceStub.find.resolves(foundVaccination);

        // WHEN
        comp.beforeRouteEnter({ params: { vaccinationId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.vaccination).toBe(foundVaccination);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
