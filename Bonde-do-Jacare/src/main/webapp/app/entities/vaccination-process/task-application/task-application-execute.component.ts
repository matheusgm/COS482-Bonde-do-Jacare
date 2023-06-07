import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskApplicationService from './task-application.service';
import { TaskApplicationContext } from './task-application.model';

const validations: any = {
  taskContext: {
    vaccinationProcess: {
      vaccination: {
        name: {},
        birthDate: {},
        job: {},
        phoneNumber: {},
        address: {},
        dateAndTime: {},
        vaccineType: {},
        applicator: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskApplicationExecuteComponent extends Vue {
  private taskApplicationService: TaskApplicationService = new TaskApplicationService();
  private taskContext: TaskApplicationContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskApplicationService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskApplicationService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
