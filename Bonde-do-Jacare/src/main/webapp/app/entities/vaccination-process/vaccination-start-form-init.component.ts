import { Component, Vue, Inject } from 'vue-property-decorator';

import { IVaccinationProcess, VaccinationProcess } from '@/shared/model/vaccination-process.model';

import { ProcessInstance, ProcessDefinitionService } from 'akip-vue-community';

import { Vaccination } from '@/shared/model/vaccination.model';
import VaccinationProcessService from './vaccination-process.service';

const validations: any = {
  vaccinationProcess: {
    vaccination: {
      name: {},
      birthDate: {},
      job: {},
    },
  },
};

@Component({
  validations,
})
export default class VaccinationStartFormInitComponent extends Vue {
  @Inject('vaccinationProcessService') private vaccinationProcessService: () => VaccinationProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'VaccinationProcess';
  public vaccinationProcess: IVaccinationProcess = new VaccinationProcess();

  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      vm.initVaccinationStartForm();
      vm.initRelationships();
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;

    this.vaccinationProcessService()
      .create(this.vaccinationProcess)
      .then(param => {
        this.isSaving = false;
        this.$router.go(-1);
        const message = this.$t('bondeDoJacareApp.vaccinationStartForm.created', { param: param.id });
        this.$root.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Success',
          variant: 'success',
          solid: true,
          autoHideDelay: 5000,
        });
      });
  }

  public initVaccinationStartForm(): void {
    this.vaccinationProcess.vaccination = new Vaccination();
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(res => {
      this.vaccinationProcess.processInstance = new ProcessInstance();
      this.vaccinationProcess.processInstance.processDefinition = res;
    });
  }
}
