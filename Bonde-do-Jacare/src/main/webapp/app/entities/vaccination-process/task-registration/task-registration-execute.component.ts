import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskRegistrationService from './task-registration.service';
import { TaskRegistrationContext } from './task-registration.model';

const validations: any = {
  taskContext: {
    vaccinationProcess: {
      vaccination: {
        name: {},
        age: {},
        job: {},
        phoneNumber: {},
        address: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskRegistrationExecuteComponent extends Vue {
  private taskRegistrationService: TaskRegistrationService = new TaskRegistrationService();
  private taskContext: TaskRegistrationContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskRegistrationService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskRegistrationService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
