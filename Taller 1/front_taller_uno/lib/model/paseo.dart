
class Paseo{
  String id;
  String name;
  String tourDate;
  String start;
  String finish;

  Paseo({
    required this.id,
    required this.name,
    required this.tourDate,
    required this.start,
    required this.finish
  });

  factory Paseo.fromJson(Map<String, dynamic> json){
    
    return Paseo(id: json['id'],
     name: json['name'],
      tourDate: json['date'],
       start: json['startLocation'],
        finish: json['endLocation']);
  }
}