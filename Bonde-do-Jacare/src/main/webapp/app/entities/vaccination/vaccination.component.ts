import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IVaccination } from '@/shared/model/vaccination.model';

import VaccinationService from './vaccination.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Vaccination extends Vue {
  @Inject('vaccinationService') private vaccinationService: () => VaccinationService;
  private removeId: number = null;

  public vaccinations: IVaccination[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllVaccinations();
  }

  public clear(): void {
    this.retrieveAllVaccinations();
  }

  public retrieveAllVaccinations(): void {
    this.isFetching = true;

    this.vaccinationService()
      .retrieve()
      .then(
        res => {
          this.vaccinations = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
