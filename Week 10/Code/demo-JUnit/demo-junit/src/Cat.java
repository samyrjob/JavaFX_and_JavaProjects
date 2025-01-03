class Cat {
    // instance variables
    String name;
    int age;
    char gender;

    Cat(String name, int age, char gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    int getHumanYears () {
        // calculation based on
        // https://www.purina.co.uk/articles/cats/senior/care/cats-age-in-human-years
        int humanAge = 0;
        if (age <= 1)
        {
            humanAge = 7;
        }
        else if (age == 2)
        {
            humanAge = 15;
        }
        else {
            humanAge = 24+(age-2)*4;
        }
        return humanAge;
    }

    // cat recites a phrase a number of times
    String [] speak (String t, int n) {
        String [] response = new String [n];
        for (int i=0; i<n; i++) {
            response[i] = t;
        }
        return response;
    }
}
