import com.android.build.api.dsl.ApplicationExtension
import com.sample.composebaseproject.configureAndroidHilt
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<ApplicationExtension> {
                configureAndroidHilt(this)
            }
        }
    }
}
