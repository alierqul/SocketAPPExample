## Sockets

 - Client-Server iletişimi için platformdan bağımsız bir seçenektir.
   
   
 - İletişim için TCP (Transmission Control  Protocol) veya UDP (User Datagram Protocol) gibi iletim protokolleri kullanılır.

   
  

 - Socketler ağ iletişiminin ayrıntılarını gizler.

   
  

 - Uygulamalar; programlama dilinden, işletim sisteminden ve ağ arayüzünden bağımsız olarak çalışır. 

   
   

 - Socket'ler için programama ara birimi (API)  tüm yaygın işletim sistemleri için desteklenir.
 
	 - Bir Uygulama açısından Socket , bir ağa erişimdir.
	 - Bağlantı yönelimli (TCP aracılığıyla) iletişime (Stream Socket)  
	 - Bağlantısız (UDP aracılığıyla) iletişime (datagram Socketleri) olarak tanınır.

   
   

 - İstemcinin sunucuyla bağlantı kurabilmesi için ;
	 - Sunucunun bir ip adresine ve bir bağlantı noktasının (Port Numarası) olması gerekir.
	 - ip adresi sunucuyu açıkça tanımlar.
	 - port numarası sunucu tarafından sağlanan hizmeti gösterir.
	

   
  

 - Avantajları:
	 - Kolay ama zahmetli.
	 - Dil, platform ve işletim sisteminden bağımsız
	 - Hızlı Öğrenim mümkün
	 - Küçük uygulamalar az bir çabayla oluşturulabilir. Çünkü; Hiçbir Protokole uyulması gerekmez.
	 - Çok hızlı uygulanabilir.
 - DezAvantajları
	 - Nesne Yönelimli Değil. Yani Sunucuya uygulama odaklı erişebilmek için geliştiricinin kendi protokolünü hazırlaması gerekir.
	 - Her Ayrıntının programlanması gerekir.
		 - Bağlantı Kurulması, Kesilmesi
		 - EşZamanlılık
		 - Şifreleme ve çok daha fazlası
	 - Aktarılacak veriler , aktarım için hazırlanmalı ve sonradan işlenmelidir.
	 - Method Çağrıları vb.  için bir ara katman gereklidir.
