# TCXZpot [![Build Status](https://travis-ci.org/SweetzpotAS/TCXZpot-Java.svg?branch=master)](https://travis-ci.org/SweetzpotAS/TCXZpot-Java)

A fluent Java library to create TCX files. Please, note this is a Work In Process library that does not include all features supported in TCX yet. They will be added in future releases.

For a detailed specification of the TCX format, visit [Garmin specification](http://www8.garmin.com/xmlschemas/TrainingCenterDatabasev2.xsd).

### Supported features

The root of a TCX file is a `TrainingCenterDatabase` which can have children of multiple types. The supported ones are:

- ❌ Folders
- ✅ Activities
- ❌ Workouts
- ❌ Courses
- ✅ Author
- ❌ Extensions

Within the supported modules, everything has been implemented except Extensions.

### Sample

You can easily create TCX files with a fluent syntax in TCXZpot:

``` java
FileSerializer serializer = new FileSerializer(new File("./sample.tcx"));
trainingCenterDatabase()
    .withActivities(activities(
        activity(RUNNING)
            .withID(tcxDate(10, FEBRUARY, 2017, 10, 42, 0))
            .withCreator(
                device("BreathZpot Sensor")
                    .withVersion(version().major(1).minor(0))
                    .withUnitId(1)
                    .withProductId(1234567)
                )
            .withNotes(notes("A sample session"))
            .withLaps(
                aLap(tcxDate(10, FEBRUARY, 2017, 10, 42, 0))
                    .withTotalTime(3000)
                    .withDistance(1200)
                    .withCalories(100)
                    .withIntensity(ACTIVE)
                    .withTriggerMethod(MANUAL)
                    .withTracks(
                        trackWith(
                            aTrackpoint()
                                .onTime(tcxDate(10, FEBRUARY, 2017, 10, 42, 15))
                                .withPosition(position(-3.6714, 36.8936)),
                            aTrackpoint()
                                .onTime(tcxDate(10, FEBRUARY, 2017, 10, 42, 43))
                                .withPosition(position(-3.6727, 36.8946)),
                            aTrackpoint()
                                .onTime(tcxDate(10, FEBRUARY, 2017, 10, 43, 20))
                                .withPosition(position(-3.6733, 36.901))
                            )
                        )
            )
        ))
    .withAuthor(
        application("BreathZpot")
            .withBuild(aBuild()
                .withVersion(version().major(2).minor(3)))
                .withLanguageID("en")
                .withPartNumber("123-45678-90")
        ).build()
        .serialize(serializer);
serializer.save();
```

### Download

You can get TCXZpot from JCenter using Gradle:

``` groovy
compile 'com.sweetzpot.tcxzpot:lib:0.1.1'
```


## License

    Copyright 2017 SweetZpot AS

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
