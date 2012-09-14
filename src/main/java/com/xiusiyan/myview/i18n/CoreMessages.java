package com.xiusiyan.myview.i18n;

import java.util.Date;

import com.xiusiyan.myview.util.StringUtils;

/**
 * CoreMessages
 *
 * @author Raymond
 * @version 1.0, Dec 2, 2009
 * @see
 */
public class CoreMessages extends MessageFactory {
    private static final CoreMessages factory = new CoreMessages();

    private static final String BUNDLE_PATH = getBundlePath("core");

    public static TraceMessage versionNotSet() {
        return factory.createMessage(BUNDLE_PATH, 1);
    }

    public static TraceMessage serverStartedAt(long startDate) {
        return factory.createMessage(BUNDLE_PATH, 2, new Date(startDate));
    }

    public static TraceMessage serverShutdownAt(Date date) {
        return factory.createMessage(BUNDLE_PATH, 3, date);
    }

    public static TraceMessage agentsRunning() {
        return factory.createMessage(BUNDLE_PATH, 4);
    }

    public static TraceMessage notSet() {
        return factory.createMessage(BUNDLE_PATH, 5);
    }

    public static TraceMessage version() {
        String version = StringUtils.defaultString(MdmManifest
                .getProductVersion(), notSet().getMessage());
        return factory.createMessage(BUNDLE_PATH, 6, version);
    }

    public static TraceMessage shutdownNormally(Date date) {
        return factory.createMessage(BUNDLE_PATH, 7, date);
    }

    public static TraceMessage serverWasUpForDuration(long duration) {
        String formattedDuration = DateUtils.getFormattedDuration(duration);
        return factory.createMessage(BUNDLE_PATH, 8, formattedDuration);
    }

    public static TraceMessage configNotFoundUsage() {
        return factory.createMessage(BUNDLE_PATH, 9);
    }

    public static TraceMessage fatalErrorWhileRunning() {
        return factory.createMessage(BUNDLE_PATH, 10);
    }

    public static TraceMessage rootStackTrace() {
        return factory.createMessage(BUNDLE_PATH, 11);
    }

    public static TraceMessage exceptionStackIs() {
        return factory.createMessage(BUNDLE_PATH, 12);
    }

    public static TraceMessage messageIsOfType(Class type) {
        return factory.createMessage(BUNDLE_PATH, 18, ClassUtils
                .getSimpleName(type));
    }

    public static TraceMessage fatalErrorInShutdown() {
        return factory.createMessage(BUNDLE_PATH, 20);
    }

    public static TraceMessage normalShutdown() {
        return factory.createMessage(BUNDLE_PATH, 21);
    }

    public static TraceMessage none() {
        return factory.createMessage(BUNDLE_PATH, 22);
    }

    public static TraceMessage notClustered() {
        return factory.createMessage(BUNDLE_PATH, 23);
    }

    public static TraceMessage failedToRouterViaEndpoint(
            ImmutableEndpoint endpoint) {
        return factory.createMessage(BUNDLE_PATH, 30, endpoint);
    }

    public static TraceMessage cannotUseDisposedConnector() {
        return factory.createMessage(BUNDLE_PATH, 32);
    }

    public static TraceMessage connectorCausedError() {
        return connectorCausedError(null);
    }

    public static TraceMessage connectorCausedError(Object connector) {
        return factory.createMessage(BUNDLE_PATH, 33, connector);
    }

    public static TraceMessage endpointIsNullForListener() {
        return factory.createMessage(BUNDLE_PATH, 34);
    }

    public static TraceMessage listenerAlreadyRegistered(EndpointURI endpointUri) {
        return factory.createMessage(BUNDLE_PATH, 35, endpointUri);
    }

    public static TraceMessage objectAlreadyInitialised(String name) {
        return factory.createMessage(BUNDLE_PATH, 37, name);
    }

    public static TraceMessage componentCausedErrorIs(Object component) {
        return factory.createMessage(BUNDLE_PATH, 38, component);
    }

    public static TraceMessage objectFailedToInitialise(String string) {
        return factory.createMessage(BUNDLE_PATH, 40, string);
    }

    public static TraceMessage failedToStop(String string) {
        return factory.createMessage(BUNDLE_PATH, 41, string);
    }

    public static TraceMessage failedToStart(String string) {
        return factory.createMessage(BUNDLE_PATH, 42, string);
    }

    public static TraceMessage proxyPoolTimedOut() {
        return factory.createMessage(BUNDLE_PATH, 43);
    }

    public static TraceMessage failedToGetPooledObject() {
        return factory.createMessage(BUNDLE_PATH, 44);
    }

    public static TraceMessage objectIsNull(String string) {
        return factory.createMessage(BUNDLE_PATH, 45, string);
    }

    public static TraceMessage componentNotRegistered(String name) {
        return factory.createMessage(BUNDLE_PATH, 46, name);
    }

    public static TraceMessage failedtoRegisterOnEndpoint(String name,
            Object endpointURI) {
        return factory.createMessage(BUNDLE_PATH, 47, name, endpointURI);
    }

    public static TraceMessage failedToUnregister(String name,
            Object endpointURI) {
        return factory.createMessage(BUNDLE_PATH, 48, name, endpointURI);
    }

    public static TraceMessage endpointIsMalformed(String endpoint) {
        return factory.createMessage(BUNDLE_PATH, 51, endpoint);
    }

    public static TraceMessage transformFailedBeforeFilter() {
        return factory.createMessage(BUNDLE_PATH, 52);
    }

    public static TraceMessage transformUnexpectedType(Class class1,
            Class returnClass) {
        return factory.createMessage(BUNDLE_PATH, 53, ClassUtils
                .getSimpleName(class1), ClassUtils.getSimpleName(returnClass));
    }

    public static TraceMessage transformFailedFrom(Class clazz) {
        return factory.createMessage(BUNDLE_PATH, 55, clazz);
    }

    public static TraceMessage encryptionStrategyNotSet() {
        return factory.createMessage(BUNDLE_PATH, 56);
    }

    public static TraceMessage failedToLoadTransformer(String direction,
            String transformer) {
        return factory.createMessage(BUNDLE_PATH, 57, direction, transformer);
    }

    public static TraceMessage failedToLoad(String string) {
        return factory.createMessage(BUNDLE_PATH, 58, string);
    }

    public static TraceMessage messageNotSupportedByAdapter(String string,
            String string2) {
        return factory.createMessage(BUNDLE_PATH, 59, string, string2);
    }

    public static TraceMessage noComponentForEndpoint() {
        return factory.createMessage(BUNDLE_PATH, 64);
    }

    public static TraceMessage failedToCreate(String string) {
        return factory.createMessage(BUNDLE_PATH, 65, string);
    }

    public static TraceMessage noCorrelationId() {
        return factory.createMessage(BUNDLE_PATH, 66);
    }

    public static Object failedToDispose(String string) {
        return factory.createMessage(BUNDLE_PATH, 67, string);
    }

    public static TraceMessage failedToInvoke(String string) {
        return factory.createMessage(BUNDLE_PATH, 68, string);
    }

    public static TraceMessage cannotReadPayloadAsBytes(String type) {
        return factory.createMessage(BUNDLE_PATH, 69, type);
    }

    public static TraceMessage cannotReadPayloadAsString(String type) {
        return factory.createMessage(BUNDLE_PATH, 70, type);
    }

    public static TraceMessage cannotInstanciateFinder(String serviceFinder) {
        return factory.createMessage(BUNDLE_PATH, 73, serviceFinder);
    }

    public static TraceMessage failedToCreateObjectWith(String string,
            Object arg) {
        return factory.createMessage(BUNDLE_PATH, 74, string, arg);
    }

    public static TraceMessage objectNotSetInService(Object object,
            Object service) {
        return factory.createMessage(BUNDLE_PATH, 75, object, service);
    }

    public static TraceMessage objectNotFound(String object) {
        return factory.createMessage(BUNDLE_PATH, 76, object);
    }

    public static TraceMessage objectNotFound(String type, String object) {
        return factory.createMessage(BUNDLE_PATH, 76, type + ": " + object);
    }

    public static TraceMessage transactionMarkedForRollback() {
        return factory.createMessage(BUNDLE_PATH, 77);
    }

    public static TraceMessage transactionCannotBindToNullKey() {
        return factory.createMessage(BUNDLE_PATH, 78);
    }

    public static TraceMessage transactionCannotBindNullResource() {
        return factory.createMessage(BUNDLE_PATH, 79);
    }

    public static TraceMessage transactionSingleResourceOnly() {
        return factory.createMessage(BUNDLE_PATH, 80);
    }

    public static TraceMessage noCurrentEventForTransformer() {
        return factory.createMessage(BUNDLE_PATH, 81);
    }

    public static TraceMessage objectNotRegistered(String type, String name) {
        return factory.createMessage(BUNDLE_PATH, 82, type, name);
    }

    public static TraceMessage failedToSetPropertiesOn(String string) {
        return factory.createMessage(BUNDLE_PATH, 83, string);
    }

    public static TraceMessage failedToCreateConnectorFromUri(EndpointURI uri) {
        return factory.createMessage(BUNDLE_PATH, 84, uri);
    }

    public static TraceMessage initialisationFailure(String string) {
        return factory.createMessage(BUNDLE_PATH, 85, string);
    }

    public static TraceMessage failedToCreateEndpointFromLocation(String string) {
        return factory.createMessage(BUNDLE_PATH, 87, string);
    }

    public static TraceMessage managerAlreadyStarted() {
        return factory.createMessage(BUNDLE_PATH, 88);
    }

    public static TraceMessage noEndpointsForRouter() {
        return factory.createMessage(BUNDLE_PATH, 89);
    }

    public static TraceMessage responseTimedOutWaitingForId(int timeout,
            Object id) {
        return factory.createMessage(BUNDLE_PATH, 90, String.valueOf(timeout),
                                     id);
    }

    public static TraceMessage failedToRecevieWithTimeout(Object endpoint,
            long timeout) {
        return factory.createMessage(BUNDLE_PATH, 93, endpoint, String
                .valueOf(timeout));
    }

    public static TraceMessage failedToWriteMessageToStore(Object id,
            String storeName) {
        return factory.createMessage(BUNDLE_PATH, 94, id, storeName);
    }

    public static TraceMessage failedToReadFromStore(String absolutePath) {
        return factory.createMessage(BUNDLE_PATH, 95, absolutePath);
    }

    public static TraceMessage cannotStartTransaction(String string) {
        return factory.createMessage(BUNDLE_PATH, 96, string);
    }

    public static TraceMessage transactionCommitFailed() {
        return factory.createMessage(BUNDLE_PATH, 97);
    }

    public static TraceMessage transactionRollbackFailed() {
        return factory.createMessage(BUNDLE_PATH, 98);
    }

    public static TraceMessage transactionCannotReadState() {
        return factory.createMessage(BUNDLE_PATH, 99);
    }

    public static TraceMessage transactionResourceAlreadyListedForKey(Object key) {
        return factory.createMessage(BUNDLE_PATH, 100, key);
    }

    public static TraceMessage noOutboundRouterSetOn(String string) {
        return factory.createMessage(BUNDLE_PATH, 101, string);
    }

    public static TraceMessage transactionAvailableButActionIs(String string) {
        return factory.createMessage(BUNDLE_PATH, 103, string);
    }

    public static TraceMessage transactionNotAvailableButActionIs(String string) {
        return factory.createMessage(BUNDLE_PATH, 104, string);
    }

    public static TraceMessage noCatchAllEndpointSet() {
        return factory.createMessage(BUNDLE_PATH, 105);
    }

    public static TraceMessage interruptedQueuingEventFor(Object object) {
        return factory.createMessage(BUNDLE_PATH, 106, object);
    }

    public static TraceMessage transactionCannotUnbind() {
        return factory.createMessage(BUNDLE_PATH, 107);
    }

    public static TraceMessage transactionAlreadyBound() {
        return factory.createMessage(BUNDLE_PATH, 108);
    }

    public static TraceMessage transformFailed(String from, String to) {
        return factory.createMessage(BUNDLE_PATH, 110, from, to);
    }

    public static TraceMessage cryptoFailure() {
        return factory.createMessage(BUNDLE_PATH, 112);
    }

    public static TraceMessage schemeNotCompatibleWithConnector(String scheme,
            Class expectedClass) {
        return factory.createMessage(BUNDLE_PATH, 115, scheme, expectedClass);
    }

    public static TraceMessage authNoSecurityProvider(String providerName) {
        return factory.createMessage(BUNDLE_PATH, 117, providerName);
    }

    public static TraceMessage transactionCanOnlyBindToResources(String string) {
        return factory.createMessage(BUNDLE_PATH, 120, string);
    }

    public static TraceMessage cannotLoadFromClasspath(String string) {
        return factory.createMessage(BUNDLE_PATH, 122, string);
    }

    public static TraceMessage failedToReadPayload() {
        return factory.createMessage(BUNDLE_PATH, 124);
    }

    public static TraceMessage endpointNotFound(String endpoint) {
        return factory.createMessage(BUNDLE_PATH, 126, endpoint);
    }

    public static TraceMessage eventProcessingFailedFor(String name) {
        return factory.createMessage(BUNDLE_PATH, 127, name);
    }

    public static TraceMessage failedToDispatchToReplyto(
            ImmutableEndpoint endpoint) {
        return factory.createMessage(BUNDLE_PATH, 128, endpoint);
    }

    public static TraceMessage authTypeNotRecognised(String string) {
        return factory.createMessage(BUNDLE_PATH, 131, string);
    }

    public static TraceMessage authSecurityManagerNotSet() {
        return factory.createMessage(BUNDLE_PATH, 132);
    }

    public static TraceMessage authSetButNoContext(String name) {
        return factory.createMessage(BUNDLE_PATH, 133, name);
    }

    public static TraceMessage authDeniedOnEndpoint(EndpointURI endpointURI) {
        return factory.createMessage(BUNDLE_PATH, 134, endpointURI);
    }

    public static TraceMessage authFailedForUser(Object user) {
        return factory.createMessage(BUNDLE_PATH, 135, user);
    }

    public static TraceMessage authEndpointMustSendOrReceive() {
        return factory.createMessage(BUNDLE_PATH, 136);
    }

    public static TraceMessage transactionManagerAlreadySet() {
        return factory.createMessage(BUNDLE_PATH, 140);
    }

    public static TraceMessage failedToCreateManagerInstance(String className) {
        return factory.createMessage(BUNDLE_PATH, 144, className);
    }

    public static TraceMessage failedToClone(String string) {
        return factory.createMessage(BUNDLE_PATH, 145, string);
    }

    public static TraceMessage exceptionOnConnectorNoExceptionListener(
            String name) {
        return factory.createMessage(BUNDLE_PATH, 146, name);
    }

    public static TraceMessage uniqueIdNotSupportedByAdapter(String name) {
        return factory.createMessage(BUNDLE_PATH, 147, name);
    }

    public static TraceMessage serverNotificationManagerNotEnabled() {
        return factory.createMessage(BUNDLE_PATH, 150);
    }

    public static TraceMessage failedToScheduleWork() {
        return factory.createMessage(BUNDLE_PATH, 151);
    }

    public static TraceMessage authNoCredentials() {
        return factory.createMessage(BUNDLE_PATH, 152);
    }

    public static TraceMessage valueIsInvalidFor(String value, String parameter) {
        return factory.createMessage(BUNDLE_PATH, 154, value, parameter);
    }

    public static TraceMessage connectorWithProtocolNotRegistered(String scheme) {
        return factory.createMessage(BUNDLE_PATH, 156, scheme);
    }

    public static TraceMessage containerAlreadyRegistered(String name) {
        return factory.createMessage(BUNDLE_PATH, 155, name);
    }

    public static TraceMessage resourceManagerNotStarted() {
        return factory.createMessage(BUNDLE_PATH, 161);
    }

    public static TraceMessage resourceManagerDirty() {
        return factory.createMessage(BUNDLE_PATH, 162);
    }

    public static TraceMessage resourceManagerNotReady() {
        return factory.createMessage(BUNDLE_PATH, 163);
    }

    public static TraceMessage cannotSetObjectOnceItHasBeenSet(String string) {
        return factory.createMessage(BUNDLE_PATH, 165, string);
    }

    public static TraceMessage eventTypeNotRecognised(String string) {
        return factory.createMessage(BUNDLE_PATH, 166, string);
    }

    public static TraceMessage componentIsStopped(String name) {
        return factory.createMessage(BUNDLE_PATH, 167, name);
    }

    public static TraceMessage propertyIsNotSetOnEvent(String property) {
        return factory.createMessage(BUNDLE_PATH, 168, property);
    }

    public static TraceMessage descriptorAlreadyExists(String name) {
        return factory.createMessage(BUNDLE_PATH, 171, name);
    }

    public static TraceMessage failedToInvokeRestService(String service) {
        return factory.createMessage(BUNDLE_PATH, 172, service);
    }

    public static TraceMessage authNoEncryptionStrategy(String strategyName) {
        return factory.createMessage(BUNDLE_PATH, 174, strategyName);
    }

    public static TraceMessage headerMalformedValueIs(String header,
            String value) {
        return factory.createMessage(BUNDLE_PATH, 175, header, value);
    }

    public static TraceMessage transformOnObjectNotOfSpecifiedType(String name,
            Object expectedType) {
        return factory.createMessage(BUNDLE_PATH, 177, name, expectedType);
    }

    public static TraceMessage cannotUseTxAndRemoteSync() {
        return factory.createMessage(BUNDLE_PATH, 178);
    }

    public static TraceMessage failedToBuildMessage() {
        return factory.createMessage(BUNDLE_PATH, 180);
    }

    public static TraceMessage propertiesNotSet(String string) {
        return factory.createMessage(BUNDLE_PATH, 183, string);
    }

    public static TraceMessage failedToConvertStringUsingEncoding(
            String encoding) {
        return factory.createMessage(BUNDLE_PATH, 188, encoding);
    }

    public static TraceMessage propertyHasInvalidValue(String property,
            Object value) {
        return factory.createMessage(BUNDLE_PATH, 189, property, value);
    }

    public static TraceMessage schemeCannotChangeForRouter(String scheme,
            String scheme2) {
        return factory.createMessage(BUNDLE_PATH, 192, scheme, scheme2);
    }

    public static TraceMessage days() {
        return factory.createMessage(BUNDLE_PATH, 193);
    }

    public static TraceMessage hours() {
        return factory.createMessage(BUNDLE_PATH, 194);
    }

    public static TraceMessage minutes() {
        return factory.createMessage(BUNDLE_PATH, 195);
    }

    public static TraceMessage seconds() {
        return factory.createMessage(BUNDLE_PATH, 196);
    }

    public static TraceMessage templateCausedMalformedEndpoint(String uri,
            String newUri) {
        return factory.createMessage(BUNDLE_PATH, 197, uri, newUri);
    }

    public static TraceMessage couldNotDetermineDestinationComponentFromEndpoint(
            String endpoint) {
        return factory.createMessage(BUNDLE_PATH, 198, endpoint);
    }

    public static TraceMessage sessionValueIsMalformed(String string) {
        return factory.createMessage(BUNDLE_PATH, 201, string);
    }

    public static TraceMessage streamingFailedNoStream() {
        return factory.createMessage(BUNDLE_PATH, 205);
    }

    public static TraceMessage connectorSchemeIncompatibleWithEndpointScheme(
            Object expected, Object actual) {
        return factory.createMessage(BUNDLE_PATH, 206, expected, actual);
    }

    public static TraceMessage failedToReadAttachment(String string) {
        return factory.createMessage(BUNDLE_PATH, 207, string);
    }

    public static TraceMessage failedToInitSecurityProvider(String providerClass) {
        return factory.createMessage(BUNDLE_PATH, 208, providerClass);
    }

    public static TraceMessage streamingNotSupported(String protocol) {
        return factory.createMessage(BUNDLE_PATH, 209, protocol);
    }

    public static TraceMessage streamingComponentMustHaveOneEndpoint(String name) {
        return factory.createMessage(BUNDLE_PATH, 210, name);
    }

    public static TraceMessage streamingFailedForEndpoint(String string) {
        return factory.createMessage(BUNDLE_PATH, 212, string);
    }

    public static TraceMessage streamingEndpointsDoNotSupportTransformers() {
        return factory.createMessage(BUNDLE_PATH, 213);
    }

    public static TraceMessage streamingEndpointsMustBeUsedWithStreamingModel() {
        return factory.createMessage(BUNDLE_PATH, 214);
    }

    public static TraceMessage failedToSetProxyOnService(Object proxy,
            Class routerClass) {
        return factory.createMessage(BUNDLE_PATH, 217, proxy, routerClass);
    }

    public static TraceMessage mustSetMethodNamesOnBinding() {
        return factory.createMessage(BUNDLE_PATH, 218);
    }

    public static TraceMessage cannotFindBindingForMethod(String name) {
        return factory.createMessage(BUNDLE_PATH, 219, name);
    }

    public static TraceMessage moreThanOneConnectorWithProtocol(String protocol) {
        return factory.createMessage(BUNDLE_PATH, 221, protocol);
    }

    public static TraceMessage failedToGetOutputStream() {
        return factory.createMessage(BUNDLE_PATH, 223);
    }

    public static TraceMessage noEntryPointFoundForNoArgsMethod(
            final Object component, final String methodName) {
        return factory.createMessage(BUNDLE_PATH, 224, component, methodName);
    }

    public static TraceMessage noDelegateClassAndMethodProvidedForNoArgsWrapper() {
        return factory.createMessage(BUNDLE_PATH, 225);
    }

    public static TraceMessage noDelegateClassIfDelegateInstanceSpecified() {
        return factory.createMessage(BUNDLE_PATH, 226);
    }

    public static TraceMessage noServiceTransportDescriptor(String protocol) {
        return factory.createMessage(BUNDLE_PATH, 227, protocol);
    }

    public static TraceMessage failedToInvokeLifecycle(String phaseName,
            Object object) {
        return factory.createMessage(BUNDLE_PATH, 228, phaseName, object);
    }

    public static TraceMessage unrecognisedServiceType(String type) {
        return factory.createMessage(BUNDLE_PATH, 229, type);
    }

    public static TraceMessage serviceFinderCantFindService(String name) {
        return factory.createMessage(BUNDLE_PATH, 230, name);
    }

    public static TraceMessage inboundRouterMustUseInboundEndpoints(
            InboundRouterCollection router, ImmutableEndpoint endpoint) {
        return factory.createMessage(BUNDLE_PATH, 232, endpoint, router);
    }

    public static TraceMessage outboundRouterMustUseOutboudEndpoints(
            OutboundRouter router, ImmutableEndpoint endpoint) {
        return factory.createMessage(BUNDLE_PATH, 233, endpoint, router);
    }

    public static TraceMessage responseRouterMustUseInboundEndpoints(
            ResponseRouterCollection router, ImmutableEndpoint endpoint) {
        return factory.createMessage(BUNDLE_PATH, 234, endpoint, router);
    }

    /**
     * Returns a message that is a product informatin.
     *
     * @return message
     */
    public static TraceMessage productInformation() {
        String notset = CoreMessages.notSet().getMessage();
        return factory.createMessage(BUNDLE_PATH, 236, StringUtils
                .defaultString(MdmManifest.getProductDescription(), notset),
                                     StringUtils.defaultString(MdmManifest
                                             .getProductVersion(), notset),
                                     StringUtils.defaultString(MdmManifest
                                             .getVendorName(), notset)
                                             + " "
                                             + StringUtils
                                                     .defaultString(MdmManifest
                                                             .getVendorUrl(),
                                                                    notset));
    }

    public static TraceMessage noTransformerFoundForMessage(Class input,
            Class output) {
        return factory.createMessage(BUNDLE_PATH, 237, input.getName(), output
                .getName());
    }

    public static TraceMessage errorReadingStream() {
        return factory.createMessage(BUNDLE_PATH, 238);
    }

    public static TraceMessage invocationSuccessfulCantSetError() {
        return factory.createMessage(BUNDLE_PATH, 245);
    }

    public static TraceMessage noJtaTransactionAvailable(
            final Thread callingThread) {
        return factory.createMessage(BUNDLE_PATH, 247, StringUtils
                .defaultString(callingThread.toString()));
    }

    public static TraceMessage notMuleXaTransaction(Object tx) {
        return factory.createMessage(BUNDLE_PATH, 248, tx.getClass());
    }

    public static TraceMessage failedToProcessExtractorFunction(String name) {
        return factory.createMessage(BUNDLE_PATH, 250, name);
    }

    public static TraceMessage expressionEvaluatorNotRegistered(String key) {
        return factory.createMessage(BUNDLE_PATH, 251, key);
    }

    public static TraceMessage objectAlreadyExists(String key) {
        return factory.createMessage(BUNDLE_PATH, 252, key);
    }

    public static TraceMessage noMuleTransactionAvailable() {
        return factory.createMessage(BUNDLE_PATH, 253);
    }

    public static TraceMessage objectAlreadyRegistered(String name,
            Object origObject, Object newObject) {
        return factory
                .createMessage(BUNDLE_PATH, 254, name, origObject + "."
                        + origObject.getClass(), newObject + "."
                        + newObject.getClass());
    }

    public static TraceMessage configurationBuilderNoMatching(String resource) {
        return factory.createMessage(BUNDLE_PATH, 259, resource);
    }

    public static TraceMessage nestedRetry() {
        return factory.createMessage(BUNDLE_PATH, 261);
    }

    public static TraceMessage expressionEvaluatorReturnedNull(String name,
            String expr) {
        return factory.createMessage(BUNDLE_PATH, 263, name, expr);
    }

    public static TraceMessage expressionInvalidForProperty(String property,
            String expr) {
        return factory.createMessage(BUNDLE_PATH, 264, property, expr);
    }

    public static TraceMessage expressionMalformed(String expr, String eval) {
        return factory.createMessage(BUNDLE_PATH, 265, expr, eval);
    }

    public static TraceMessage correlationTimedOut(Object groupId) {
        return factory.createMessage(BUNDLE_PATH, 266, groupId);
    }

    public static TraceMessage transformerInvalidReturnType(Class clazz,
            String transformerName) {
        return factory.createMessage(BUNDLE_PATH, 267, clazz, transformerName);
    }

    /**
     * 
     * @deprecated Use more specific {@link #commitTxButNoResource} or
     * {@link #rollbackTxButNoResource}
     */
    @Deprecated
    public static TraceMessage noBindingResource() {
        return factory.createMessage(BUNDLE_PATH, 268);
    }

    public static TraceMessage transactionFactoryIsMandatory(String action) {
        return factory.createMessage(BUNDLE_PATH, 269, action);
    }

    public static TraceMessage failedToCreateProxyFor(Object target) {
        return factory.createMessage(BUNDLE_PATH, 270, target);
    }

    public static TraceMessage authorizationAttemptFailed() {
        return factory.createMessage(BUNDLE_PATH, 271);
    }

    public static TraceMessage retryPolicyExhausted(RetryPolicyTemplate policy) {
        return factory.createMessage(BUNDLE_PATH, 272, policy);
    }

    public static TraceMessage notConnectedYet(String what) {
        return factory.createMessage(BUNDLE_PATH, 273, what);
    }

    public static TraceMessage expressionResultWasNull(String expression) {
        return factory.createMessage(BUNDLE_PATH, 276, expression);
    }

    public static TraceMessage propertyDoesNotExistOnObject(String property,
            Object object) {
        return factory.createMessage(BUNDLE_PATH, 277, property, object);
    }

//    public static TraceMessage commitTxButNoResource(Transaction tx) {
//        return factory.createMessage(BUNDLE_PATH, 300, tx);
//    }

//    public static TraceMessage rollbackTxButNoResource(Transaction tx) {
//        return factory.createMessage(BUNDLE_PATH, 301, tx);
//    }

    public static TraceMessage cannotCopyStreamPayload(String streamType) {
        return factory.createMessage(BUNDLE_PATH, 302, streamType);
    }
}
