class IABC:public IInterface{
public :
	DECLARE_META_INTERFACE(ABC);
	virtual getABC() = 0;
	virtual setABC() = 0;
}
IMPLEMENT_META_INTERFACE(ABC, "android.abc.IABC");//IMPLEMENT宏

status_t BnABC::onTransact(
    uint32_t code, const Parcel& data, Parcel* reply, uint32_t flags)
{
    switch(code) {
        case GET_ABC: {
            CHECK_INTERFACE(IABC, data, reply);
            getABC();
            return NO_ERROR;
        } break; //SET_XXX类似
    }

}

class BpABC: public BpInterface<IABC>
{
public:
    BpABC (const sp<IBinder>& impl)
        : BpInterface< IABC >(impl)
    {
	}
vitural getABC()
{
  Parcel data, reply;
  data.writeInterfaceToken(IABC::getInterfaceDescriptor());
   data.writeInt32(pid);
   remote()->transact(GET_ABC, data, &reply);
   return;
}
}

