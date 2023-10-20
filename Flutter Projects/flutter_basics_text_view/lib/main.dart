import 'package:flutter/material.dart';

void main() {
  runApp(MyCustomForm());
}

String appTitle = "Form";

class MyCustomForm extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: appTitle,
      home: Scaffold(
        appBar: AppBar(
          title: const Text("Form Example"),
        ),
        body: FormContent(),
      ),
    );
  }
}

class FormContent extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          const Padding(
            padding: EdgeInsets.symmetric(horizontal: 8, vertical: 16),
            child: TextField(
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                hintText: "Enter a search term",
              ),
            ),
          ),
          Padding(padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 16),
          child: TextFormField(
            decoration: const InputDecoration(
              border: UnderlineInputBorder(),
              labelText: "Enter user name"
            ),
          )
          ),
          ElevatedButton(
            onPressed: () {
              print("Submitted");
            },
            child: Text("Submit"),
          ),
        ],
      ),
    );
  }
}
