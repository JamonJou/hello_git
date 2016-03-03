class BnABC : public BnInterface<IABC>
{
public :
	virtual status_t onTransact(
		uint32_t code,
		const Pacel& data,
		Pacel *reply,
		uint32_t flags=0
	);

}
