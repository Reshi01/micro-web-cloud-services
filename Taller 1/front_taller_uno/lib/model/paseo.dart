
class Paseo{
  String id;
  String name;
  DateTime tourDate;
  int start;
  int finish;

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
      tourDate: json['tour_date'],
       start: json['start'],
        finish: json['finish']);
  }
}