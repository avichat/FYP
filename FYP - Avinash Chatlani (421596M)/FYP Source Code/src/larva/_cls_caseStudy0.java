package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_caseStudy0 implements _callable{

public static PrintWriter pw; 
public static _cls_caseStudy0 root;

public static LinkedHashMap<_cls_caseStudy0,_cls_caseStudy0> _cls_caseStudy0_instances = new LinkedHashMap<_cls_caseStudy0,_cls_caseStudy0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\Owner\\workspace\\FYPAJ/src/output_caseStudy.txt");

root = new _cls_caseStudy0();
_cls_caseStudy0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_caseStudy0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_caseStudy0() {
}

public void initialisation() {
}

public static _cls_caseStudy0 _get_cls_caseStudy0_inst() { synchronized(_cls_caseStudy0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_caseStudy0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_caseStudy0_instances){
_performLogic_caseStudyProperty(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_caseStudy0[] a = new _cls_caseStudy0[1];
synchronized(_cls_caseStudy0_instances){
a = _cls_caseStudy0_instances.keySet().toArray(a);}
for (_cls_caseStudy0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_caseStudy0_instances){
_cls_caseStudy0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_caseStudyProperty = 38;

public void _performLogic_caseStudyProperty(String _info, int... _event) {

_cls_caseStudy0.pw.println("[caseStudyProperty]AUTOMATON::> caseStudyProperty("+") STATE::>"+ _string_caseStudyProperty(_state_id_caseStudyProperty, 0));
_cls_caseStudy0.pw.flush();

if (0==1){}
else if (_state_id_caseStudyProperty==38){
		if (1==0){}
		else if ((_occurredEvent(_event,60/*USER_login*/))){
		
		_state_id_caseStudyProperty = 36;//moving to state F_12131415161819
		_goto_caseStudyProperty(_info);
		}
		else if ((_occurredEvent(_event,62/*ADMIN_initialise*/))){
		
		_state_id_caseStudyProperty = 37;//moving to state N_21
		_goto_caseStudyProperty(_info);
		}
}
else if (_state_id_caseStudyProperty==37){
		if (1==0){}
		else if ((_occurredEvent(_event,60/*USER_login*/))){
		
		_state_id_caseStudyProperty = 37;//moving to state N_21
		_goto_caseStudyProperty(_info);
		}
		else if ((_occurredEvent(_event,62/*ADMIN_initialise*/))){
		
		_state_id_caseStudyProperty = 37;//moving to state N_21
		_goto_caseStudyProperty(_info);
		}
}
else if (_state_id_caseStudyProperty==36){
		if (1==0){}
		else if ((_occurredEvent(_event,60/*USER_login*/))){
		
		_state_id_caseStudyProperty = 36;//moving to state F_12131415161819
		_goto_caseStudyProperty(_info);
		}
		else if ((_occurredEvent(_event,62/*ADMIN_initialise*/))){
		
		_state_id_caseStudyProperty = 37;//moving to state N_21
		_goto_caseStudyProperty(_info);
		}
}
}

public void _goto_caseStudyProperty(String _info){
_cls_caseStudy0.pw.println("[caseStudyProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_caseStudyProperty(_state_id_caseStudyProperty, 1));
_cls_caseStudy0.pw.flush();
}

public String _string_caseStudyProperty(int _state_id, int _mode){
switch(_state_id){
case 37: if (_mode == 0) return "N_21"; else return "N_21";
case 38: if (_mode == 0) return "S_11121315171920"; else return "S_11121315171920";
case 36: if (_mode == 0) return "F_12131415161819"; else return "!!!SYSTEM REACHED BAD STATE!!! F_12131415161819 "+new _BadStateExceptioncaseStudy().toString()+" ";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}