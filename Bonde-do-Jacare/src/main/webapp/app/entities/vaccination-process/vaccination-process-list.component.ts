import { Component, Vue, Inject } from 'vue-property-decorator';
import { IVaccinationProcess } from '@/shared/model/vaccination-process.model';

import { ProcessDefinition, ProcessDefinitionService } from 'akip-vue-community';

import VaccinationProcessService from './vaccination-process.service';

@Component
export default class VaccinationProcessListComponent extends Vue {
  @Inject('vaccinationProcessService') private vaccinationProcessService: () => VaccinationProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'VaccinationProcess';
  public processDefinition: ProcessDefinition = new ProcessDefinition();
  public vaccinationProcessList: IVaccinationProcess[] = [];

  public isFetchingProcessDefinition = false;
  public isFetchingProcessInstances = false;

  public mounted(): void {
    this.init();
  }

  public init(): void {
    this.retrieveProcessDefinition();
    this.retrieveProcessInstances();
  }

  public retrieveProcessDefinition() {
    this.isFetchingProcessDefinition = true;
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(
      res => {
        this.processDefinition = res;
        this.isFetchingProcessDefinition = false;
      },
      err => {
        this.isFetchingProcessDefinition = false;
      }
    );
  }

  public retrieveProcessInstances(): void {
    this.isFetchingProcessInstances = true;
    this.vaccinationProcessService()
      .retrieve()
      .then(
        res => {
          this.vaccinationProcessList = res.data;
          this.isFetchingProcessInstances = false;
        },
        err => {
          this.isFetchingProcessInstances = false;
        }
      );
  }

  get isFetching(): boolean {
    return this.isFetchingProcessDefinition && this.isFetchingProcessInstances;
  }

  public handleSyncList(): void {
    this.retrieveProcessInstances();
  }

  public previousState(): void {
    this.$router.go(-1);
  }
}
