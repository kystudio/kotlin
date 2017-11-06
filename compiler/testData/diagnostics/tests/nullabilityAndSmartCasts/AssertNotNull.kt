// !WITH_NEW_INFERENCE
// !CHECK_TYPE

fun main(args : Array<String>) {
    val a : Int? = null
    val b : Int? = null
    checkSubtype<Int>(a!!)
    a<!NI;UNNECESSARY_NOT_NULL_ASSERTION!><!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!><!> + 2
    a<!NI;UNNECESSARY_NOT_NULL_ASSERTION!><!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!><!>.plus(2)
    a<!NI;UNNECESSARY_NOT_NULL_ASSERTION!><!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!><!>.plus(b!!)
    2.plus(b<!NI;UNNECESSARY_NOT_NULL_ASSERTION!><!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!><!>)
    2 + b<!NI;UNNECESSARY_NOT_NULL_ASSERTION!><!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!><!>

    val c = 1
    c<!NI;UNNECESSARY_NOT_NULL_ASSERTION!><!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!><!>

    val d : Any? = null

    if (d != null) {
        d<!NI;UNNECESSARY_NOT_NULL_ASSERTION!><!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!><!>
    }

    // smart cast isn't needed, but is reported due to KT-4294
    if (d is String) {
        <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>d<!><!><!NI;UNNECESSARY_NOT_NULL_ASSERTION!><!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!><!>
    }

    if (d is String?) {
        if (d != null) {
            <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>d<!><!><!NI;UNNECESSARY_NOT_NULL_ASSERTION!><!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!><!>
        }
        if (d is String) {
            <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>d<!><!><!NI;UNNECESSARY_NOT_NULL_ASSERTION!><!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!><!>
        }
    }

    val <!NI;UNUSED_VARIABLE!><!UNUSED_VARIABLE!>f<!><!> : String = <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>a<!><!><!NI;UNNECESSARY_NOT_NULL_ASSERTION!><!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!><!>
    checkSubtype<String>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>a<!><!NI;UNNECESSARY_NOT_NULL_ASSERTION!><!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!><!><!><!>)
}