create table channel (
						 channel_id bigint generated by default as identity,
						 agency_id bigint,
						 v_tuber_id bigint,
						 type varchar(100),
						 url varchar(255),
						 created_at       timestamp(6),
						 last_modified_at timestamp(6),
						 constraint pk_channel primary key (channel_id)
);

alter table public.channel
	add constraint fk_channel_to_agency
		foreign key (agency_id) references public.agency;

alter table public.channel
	add constraint fk_channel_to_v_tuber
		foreign key (v_tuber_id) references public.v_tuber;