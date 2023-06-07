/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import VaccinationComponent from '@/entities/vaccination/vaccination.vue';
import VaccinationClass from '@/entities/vaccination/vaccination.component';
import VaccinationService from '@/entities/vaccination/vaccination.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('Vaccination Management Component', () => {
    let wrapper: Wrapper<VaccinationClass>;
    let comp: VaccinationClass;
    let vaccinationServiceStub: SinonStubbedInstance<VaccinationService>;

    beforeEach(() => {
      vaccinationServiceStub = sinon.createStubInstance<VaccinationService>(VaccinationService);
      vaccinationServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<VaccinationClass>(VaccinationComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          vaccinationService: () => vaccinationServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      vaccinationServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllVaccinations();
      await comp.$nextTick();

      // THEN
      expect(vaccinationServiceStub.retrieve.called).toBeTruthy();
      expect(comp.vaccinations[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
