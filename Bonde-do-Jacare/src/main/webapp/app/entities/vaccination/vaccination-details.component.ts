import { Component, Vue, Inject } from 'vue-property-decorator';

import { IVaccination } from '@/shared/model/vaccination.model';
import VaccinationService from './vaccination.service';

@Component
export default class VaccinationDetails extends Vue {
  @Inject('vaccinationService') private vaccinationService: () => VaccinationService;
  public vaccination: IVaccination = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.vaccinationId) {
        vm.retrieveVaccination(to.params.vaccinationId);
      }
    });
  }

  public retrieveVaccination(vaccinationId) {
    this.vaccinationService()
      .find(vaccinationId)
      .then(res => {
        this.vaccination = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
