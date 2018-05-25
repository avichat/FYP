package aspects;

import larva.*;
public aspect _asp_caseStudy0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_caseStudy0.initialize();
}
}
before () : (call(* *.USER_login(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_caseStudy0.lock){

_cls_caseStudy0 _cls_inst = _cls_caseStudy0._get_cls_caseStudy0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 60/*USER_login*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 60/*USER_login*/);
}
}
before () : (call(* *.ADMIN_initialise(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_caseStudy0.lock){

_cls_caseStudy0 _cls_inst = _cls_caseStudy0._get_cls_caseStudy0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 62/*ADMIN_initialise*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 62/*ADMIN_initialise*/);
}
}
}