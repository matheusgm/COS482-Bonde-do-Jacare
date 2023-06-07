import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskRegistrationService from './task-registration.service';
import { TaskRegistrationContext } from './task-registration.model';

@Component
export default class TaskRegistrationDetailsComponent extends Vue {
  private taskRegistrationService: TaskRegistrationService = new TaskRegistrationService();
  private taskContext: TaskRegistrationContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskRegistrationService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
