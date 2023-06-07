import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskApplicationService from './task-application.service';
import { TaskApplicationContext } from './task-application.model';

@Component
export default class TaskApplicationDetailsComponent extends Vue {
  private taskApplicationService: TaskApplicationService = new TaskApplicationService();
  private taskContext: TaskApplicationContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskApplicationService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
