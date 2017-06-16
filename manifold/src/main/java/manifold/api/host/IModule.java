package manifold.api.host;

import java.util.List;
import java.util.Set;
import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;
import manifold.api.fs.IDirectory;
import manifold.api.fs.IFile;
import manifold.api.fs.IFileSystem;
import manifold.api.sourceprod.ISourceProducer;

/**
 */
public interface IModule
{
  String getName();

  /**
   * The path[s] having source files that should be exposed to this module.
   */
  List<IDirectory> getSourcePath();

  List<IDirectory> getJavaClassPath();

  IDirectory getOutputPath();

  IDirectory[] getExcludedPath();

  List<IDirectory> getCollectiveSourcePath();

  List<IDirectory> getCollectiveJavaClassPath();

  IFileSystem getFileSystem();

  /**
   * @return A list of dependency modules.
   * The dependency graph must not have cycles.
   */
  List<Dependency> getDependencies();

  Set<ISourceProducer> getSourceProducers();

  Set<ISourceProducer> findSourceProducersFor( String fqn );
  Set<ISourceProducer> findSourceProducersFor( IFile file );

  JavaFileObject produceFile( String fqn, DiagnosticListener<JavaFileObject> errorHandler );
}
