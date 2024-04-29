--1
select * from public.clienti where nome='Mario';

--2
select nome,cognome from public.clienti where anno_di_nascita = 1982; 

--3
select count(*) from public.fatture where iva = 20; 

--4
select * from public.prodotti 
where EXTRACT(year from data_attivazione) = 2017 
and in_commercio = true or in_produzione = true; 

--5
select * from public.fatture f 
inner join public.clienti c 
on importo < 1000 and f.id_cliente=c.numero_cliente;

--6	
select fa.numero_fattura, fa.importo, fa.iva, fa.data_fattura, fo.denominazione 
from public.fatture fa 
inner join public.fornitori fo 
on fa.numero_fornitore=fo.numero_fornitore; 

--7
select EXTRACT(year from data_fattura) anno, 
COUNT(*) numero_fatture 
from public.fatture
where iva = 20 
group by anno;

--8
select EXTRACT(year from data_fattura) anno, 
count (*) numero_fatture, 
sum(importo) importo_totale
from public.fatture 
group by anno;

--9
select EXTRACT(year from data_fattura) anno from public.fatture
where tipologia like '%A%' -- non posso mettere il count() qui
group by anno 
having count(*) > 2; 

--10
select sum(f.importo) importo_totale, c.regione_residenza
from public.fatture f
inner join public.clienti c on f.id_cliente = c.numero_cliente
group by c.regione_residenza;

--11
select count(distinct c.numero_cliente) numero_clienti
from public.clienti c
inner join public.fatture fa on c.numero_cliente=fa.id_cliente
where EXTRACT(year from c.anno_di_nascita) = 1980 and fa.importo >= 50;



