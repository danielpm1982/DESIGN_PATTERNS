package chainOfResponsability;
public class HandlerInitial implements HandlerInterface{
    HandlerInterface sucessor;
    String handlerType;
    public HandlerInitial(HandlerInterface sucessor) {
        this.sucessor=sucessor;
        this.handlerType=RequestType.Type0.toString();
    }
    @Override
    public void handleRequest(RequestInterface request) {
        if(request.getType().equals(handlerType)){
            System.out.println("Congratulations! Your request has been successfully handled by "+this.getClass().getSimpleName());
        } else{
            System.out.println("Sorry! "+this.getClass().getSimpleName()+" unable to handle the request. Sending it to another handler...");
            sucessor.handleRequest(request);
        }
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
