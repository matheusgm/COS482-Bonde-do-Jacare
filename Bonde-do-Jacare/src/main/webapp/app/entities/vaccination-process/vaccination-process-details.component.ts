import { Component, Vue, Inject } from 'vue-property-decorator';

import { IVaccinationProcess } from '@/shared/model/vaccination-process.model';
import VaccinationProcessService from './vaccination-process.service';

@Component
export default class VaccinationProcessDetailsComponent extends Vue {
  @Inject('vaccinationProcessService') private vaccinationProcessService: () => VaccinationProcessService;
  public vaccinationProcess: IVaccinationProcess = {};

  public isFetching: boolean = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processInstanceId) {
        vm.retrieveVaccinationProcess(to.params.processInstanceId);
      }
    });
  }

  public retrieveVaccinationProcess(vaccinationProcessId) {
    this.isFetching = true;
    this.vaccinationProcessService()
      .find(vaccinationProcessId)
      .then(
        res => {
          this.vaccinationProcess = res;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public previousState() {
    this.$router.go(-1);
  }
}
