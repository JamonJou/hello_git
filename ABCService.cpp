int main(){
sp<ProcessState> proc(ProcessState::self());
sp<IServiceManager> sm=defaultServiceManager();
sm->addService("service.abc",new ABCService());
ProcessState::self()->startThreadPool();
IPCThreadState::self()->joinThreadPool();
}
